const username = localStorage.getItem('florence_username');
if (!username) location.href = 'index.html';

const start = Date.now();
let elapsedSeconds = 0;
let physicsValidated = false;
let answerSubmitted = false;
let points = 0;

const timerEl = document.getElementById('timer');
const timerInterval = setInterval(() => {
  elapsedSeconds = Math.floor((Date.now() - start) / 1000);
  const min = String(Math.floor(elapsedSeconds / 60)).padStart(2,'0');
  const sec = String(elapsedSeconds % 60).padStart(2,'0');
  timerEl.textContent = `${min}:${sec}`;
}, 250);

const values = {
  m: 0.5, c: 900, dt: 630, m2: 0.5, lf: 397000,
  h: 20, g: 10, t: 2, a: 60, v0: 30
};

function checkNumber(id, expected) {
  const input = document.getElementById(id);
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
    result.className = 'validation error';
    result.textContent = 'EVIDÊNCIAS INCONSISTENTES. Revise os valores destacados.';
    return;
  }

  const q1 = values.m * values.c * values.dt;
  const q2 = values.m2 * values.lf;
  const qtotal = q1 + q2;
  const calculatedT = Math.sqrt((2 * values.h) / values.g);
  const calculatedV = values.a / calculatedT;

  physicsValidated = true;
  result.className = 'validation success';
  result.innerHTML = `CÁLCULO VALIDADO: Q₁ = ${q1.toLocaleString('pt-BR')} J · Q₂ = ${q2.toLocaleString('pt-BR')} J · Qtotal = <strong>${qtotal.toLocaleString('pt-BR')} J</strong> · t = ${calculatedT} s · v₀ = <strong>${calculatedV} m/s</strong>`;

  document.getElementById('solutions').classList.remove('hidden');
  buildOptions();
});

const solutionData = [
  {text:'O caso foi um curto-circuito acidental que derreteu o alumínio e iniciou o incêndio.', correct:false},
  {text:'O incêndio começou por um fenômeno natural, e as marcas de impacto são consequências posteriores.', correct:false},
  {text:'A combinação de energia térmica, fusão uniforme do alumínio e trajetória de 30 m/s indica um incêndio criminoso planejado, com artefatos lançados de uma posição elevada.', correct:true},
  {text:'As peças metálicas fundiram por contato direto com a terra aquecida, sem necessidade de uma fonte externa prolongada.', correct:false},
  {text:'O padrão de queima prova apenas que o vento estava excepcionalmente forte durante o acidente.', correct:false}
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
  }, {once:true});
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
  localStorage.setItem('florence_case', 'genocidio');

  const final = document.getElementById('finalResult');
  final.className = correct ? 'validation success' : 'validation error';
  final.textContent = correct
    ? 'CONCLUSÃO CORRETA. +3 pontos de investigação.'
    : 'CONCLUSÃO INCORRETA. Pontuação da resposta: 0.';

  document.getElementById('submitAnswer').disabled = true;
  document.querySelectorAll('input[name="solution"]').forEach(x => x.disabled = true);

  setTimeout(() => location.href = 'ranking.html', 1800);
});
