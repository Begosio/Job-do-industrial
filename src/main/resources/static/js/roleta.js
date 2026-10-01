const username = localStorage.getItem('florence_username');
if (!username) location.href = 'index.html';

document.getElementById('userBadge').textContent = username || '';

const wheel = document.getElementById('wheel');
const btn = document.getElementById('spinBtn');
const result = document.getElementById('result');

const cases = ['fraude', 'genocidio', 'assassinato'];
const names = {
  fraude: 'FRAUDE',
  genocidio: 'GENOCÍDIO',
  assassinato: 'ASSASSINATO'
};

let spinning = false;

btn.addEventListener('click', () => {
  if (spinning) return;

  spinning = true;
  btn.disabled = true;
  result.textContent = 'ANALISANDO DISTRIBUIÇÃO...';

  const selected = cases[Math.floor(Math.random() * cases.length)];
  localStorage.setItem('florence_case', selected);

  const index = cases.indexOf(selected);
  const sectorCenter = index * 120 + 60;
  const extra = 360 * (5 + Math.floor(Math.random() * 3));
  const targetRotation = extra + (360 - sectorCenter);

  wheel.style.transform = `rotate(${targetRotation}deg)`;

  setTimeout(() => {
    result.textContent = `CASO DESIGNADO: ${names[selected]}`;

    setTimeout(() => {
      location.href = selected + '.html';
    }, 1200);
  }, 4500);
});
