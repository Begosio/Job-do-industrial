document.getElementById('registerForm').addEventListener('submit', (e) => {
  e.preventDefault();
  const username = document.getElementById('username').value.trim();
  if (!username) return;

  localStorage.setItem('florence_username', username);
  localStorage.removeItem('florence_points');
  localStorage.removeItem('florence_time');
  localStorage.removeItem('florence_case');

  location.href = 'roleta.html';
});
