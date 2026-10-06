console.log("rank carregou")
alert("kdaodkaodkaoad")
const multipliers = [25, 18, 15, 12, 10, 8, 6, 4, 2, 1];

async function loadRankingFromAPI() {
  try {
    const response = await fetch('/tentativa');

    if (!response.ok) {
      throw new Error(`Erro HTTP: ${response.status}`);
    }

    const tentativas = await response.json();

    return tentativas;

  } catch (error) {
    console.error('Erro ao buscar tentativas do banco:', error);

    return [];
  }
}

async function saveAndRender() {

  // Busca os dados diretamente do banco através da API
  const existing = await loadRankingFromAPI();

  const body = document.getElementById('rankingBody');

  body.innerHTML = '';

  // Organiza os dados recebidos do banco
  const rows = existing
    .map(item => ({
      id: item.id,
      idUsuario: item.idUsuario,
      idCaso: item.idCaso,
      pontuacaoFinal: Number(item.pontuacaoFinal ?? 0)
    }))

    // Maior pontuação primeiro
    .sort((a, b) => b.pontuacaoFinal - a.pontuacaoFinal);

  // Exibe cada tentativa na tabela
  rows.forEach((r, i) => {

    const multiplier = multipliers[i] || 1;

    const finalScore = r.pontuacaoFinal * multiplier;

    const tr = document.createElement('tr');

    tr.innerHTML = `
      <td>${i + 1}</td>
      <td>${r.idUsuario}</td>
      <td>${r.idCaso}</td>
      <td>${r.pontuacaoFinal}</td>
      <td>x${multiplier}</td>
      <td><strong>${finalScore}</strong></td>
    `;

    body.appendChild(tr);
  });

  // Nenhum registro encontrado
  if (rows.length === 0) {

    document.getElementById('summary').textContent =
      'Nenhuma tentativa registrada no banco ainda.';

    return;
  }

  // Resumo baseado nos dados que vieram do banco
  const melhorPontuacao = rows[0].pontuacaoFinal;

  document.getElementById('summary').innerHTML = `
    Maior pontuação registrada:
    <strong>${melhorPontuacao}</strong>
  `;
}

saveAndRender();

