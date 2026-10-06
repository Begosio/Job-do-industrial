console.log("assalto.js encontrado!")

const casoId = localStorage.getItem('florence_case_id');
const username = localStorage.getItem('florence_username');
if (!username) location.href = 'index.html';

const start = Date.now();
let elapsedSeconds = 0;
let physicsValidated = false;
let answerSubmitted = false;
let points = 0;

const timerEl = document.getElementById('timer');
if (timerEl) {
  const timerInterval = setInterval(() => {
    elapsedSeconds = Math.floor((Date.now() - start) / 1000);
    const min = String(Math.floor(elapsedSeconds / 60)).padStart(2, '0');
    const sec = String(elapsedSeconds % 60).padStart(2, '0');
    timerEl.textContent = `${min}:${sec}`;
  }, 250);
}

// Corrige a validação para os campos reais do caso de assalto e evita erro ao acessar um input inexistente.
const values = {
  s: 18,
  t: 0.15,
  vm: 120,
  h: 180,
  g: 10,
  tQueda: 6,
  vImpacto: 60,
  corrente: 3.6,
  tempoRio: 22
};

function checkNumber(id, expected) {
  const input = document.getElementById(id);
  if (!input) {
    return false;
  }

  const value = Number(input.value);
  const ok = Number.isFinite(value) && Math.abs(value - expected) < 0.001;
  input.classList.toggle('valid', ok);
  input.classList.toggle('invalid', !ok);
  return ok;
}

document.getElementById('checkPhysics').addEventListener('click', () => {
  const ids = Object.keys(values);
  const allOk = ids.every(id => checkNumber(id, values[id]));
  const result = document.getElementById('physicsResult');

  if (!allOk) {
    physicsValidated = false;
    document.getElementById('submitEvidence').disabled = true;
    result.className = 'validation error';
    result.textContent = 'EVIDÊNCIAS INCONSISTENTES. Revise os valores destacados.';
    return;
  }

  const calculatedT = Math.sqrt((2 * values.h) / values.g);
  const calculatedV = values.g * values.tQueda;
  const riverDistance = values.corrente * values.tempoRio * 60;

  physicsValidated = true;
  document.getElementById('submitEvidence').disabled = false;
  result.className = 'validation success';
  result.innerHTML = `CÁLCULO VALIDADO: v = s/t = ${values.vm} km/h · t = √(2h/g) = ${calculatedT.toFixed(2)} s · v = g·t = ${calculatedV} m/s · deslocamento do rio = ${riverDistance.toLocaleString('pt-BR')} m`;

  document.getElementById('solutions').classList.remove('hidden');
  buildOptions();
});

document.getElementById('submitEvidence').addEventListener('click', () => {
  if (!physicsValidated) return;

  const evidenceResult = document.getElementById('evidenceResult');
  evidenceResult.className = 'validation success';
  evidenceResult.textContent = 'EVIDÊNCIAS REGISTRADAS. A velocidade, a altura e a corrente do rio batem com o cenário do assalto.';
});

const solutionData = [
  { text: 'A fuga foi preparada para esconder o veículo na doca, usando o rio como rota de desvio depois do impacto.', correct: true },
  { text: 'O assalto foi um acidente de trânsito sem planejamento prévio.', correct: false },
  { text: 'Os dados físicos mostram que o veículo caiu por erro do condutor após o pedágio.', correct: false },
  { text: 'A ponte foi abandonada por causa do vento forte e da chuva intensa.', correct: false },
  { text: 'O comboio não conseguiu manter velocidade suficiente para escapar do local.', correct: false }
];

function buildOptions() {
  const container = document.getElementById('options');
  container.innerHTML = '';
  solutionData.forEach((item, i) => {
    const label = document.createElement('label');
    label.className = 'option';
    label.innerHTML = `<input type="radio" name="solution" value="${i}"><span>${item.text}</span>`;
    container.appendChild(label);
  });
  container.addEventListener('change', () => {
    document.getElementById('submitAnswer').disabled = false;
  }, { once: true });
}

document.getElementById('submitAnswer').addEventListener('click', () => {
  if (answerSubmitted || !physicsValidated) return;
  const selected = document.querySelector('input[name="solution"]:checked');
  if (!selected) return;

  answerSubmitted = true;
  const correct = solutionData[Number(selected.value)].correct;
  points = correct ? 3 : 0;

  localStorage.setItem('florence_time', String(elapsedSeconds));
  localStorage.setItem('florence_points', String(points));
  localStorage.setItem('florence_case', 'assalto');

  const final = document.getElementById('finalResult');
  final.className = correct ? 'validation success' : 'validation error';
  final.textContent = correct
    ? 'CONCLUSÃO CORRETA. +3 pontos de investigação.'
    : 'CONCLUSÃO INCORRETA. Pontuação da resposta: 0.';

  document.getElementById('submitAnswer').disabled = true;
  document.querySelectorAll('input[name="solution"]').forEach(x => x.disabled = true);

  setTimeout(() => location.href = 'ranking.html', 1800);
});

