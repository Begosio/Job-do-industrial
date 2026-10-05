const username = localStorage.getItem('florence_username') || 'Investigador';
const time = Number(localStorage.getItem('florence_time') || 0);
const points = Number(localStorage.getItem('florence_points') || 0);

const multipliers = [25, 18, 15, 12, 10, 8, 6, 4, 2, 1];

function formatTime(sec) {
  const m = String(Math.floor(sec / 60)).padStart(2, '0');
  const s = String(sec % 60).padStart(2, '0');
  return `${m}:${s}`;
}

/*
  FUTURA API:
  Substitua o conteúdo desta função por:
  const response = await fetch('/api/ranking');
  return await response.json();

  Formato esperado:
  [{ username: "Ana", time: 73, points: 3 }, ...]
*/
async function loadRankingFromAPI() {
  // Enquanto o backend não existe, usamos localStorage como banco temporário.
  return JSON.parse(localStorage.getItem('florence_ranking') || '[]');
}

async function saveAndRender() {
  const existing = await loadRankingFromAPI();

  // Evita duplicação do mesmo resultado desta sessão.
  const sessionId = sessionStorage.getItem('florence_session_id') || crypto.randomUUID();
  sessionStorage.setItem('florence_session_id', sessionId);

  const record = { id: sessionId, username, time, points };
  const index = existing.findIndex(r => r.id === sessionId);
  if (index >= 0) existing[index] = record;
  else existing.push(record);

  existing.sort((a, b) => a.time - b.time);

  // Multiplicadores: 1º=25, 2º=18, 3º=15 ... 10º=1.
  // Acima do 10º, o multiplicador fica em 1.
  existing.forEach((r, i) => {
    r.multiplier = multipliers[i] || 1;
    r.finalScore = r.points * r.multiplier;
  });

  localStorage.setItem('florence_ranking', JSON.stringify(existing));

  const body = document.getElementById('rankingBody');
  body.innerHTML = '';

  existing.forEach((r, i) => {
    const tr = document.createElement('tr');
    if (r.id === sessionId) tr.className = 'current-player';
    tr.innerHTML = `
      <td>${i + 1}</td>
      <td>${escapeHTML(r.username)}</td>
      <td>${formatTime(r.time)}</td>
      <td>${r.points} / 3</td>
      <td>x${r.multiplier}</td>
      <td><strong>${r.finalScore}</strong></td>`;
    body.appendChild(tr);
  });

  const my = existing.find(r => r.id === sessionId);
  document.getElementById('summary').innerHTML =
    `Investigador <strong>${escapeHTML(username)}</strong> · tempo <strong>${formatTime(time)}</strong> · resposta <strong>${points}/3</strong> · pontuação final <strong>${my.finalScore}</strong>.`;
}

function escapeHTML(str) {
  return String(str).replace(/[&<>"']/g, c => ({
    '&': '&amp;', '<': '&lt;', '>': '&gt;', '"': '&quot;', "'": '&#039;'
  }[c]));
}
saveAndRender();
