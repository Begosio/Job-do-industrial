// Cronômetro base para os casos ainda em construção.
const start = Date.now();

setInterval(() => {
  const seconds = Math.floor((Date.now() - start) / 1000);
  const minutes = String(Math.floor(seconds / 60)).padStart(2, '0');
  const secs = String(seconds % 60).padStart(2, '0');

  document.getElementById('timer').textContent = `${minutes}:${secs}`;
}, 250);
