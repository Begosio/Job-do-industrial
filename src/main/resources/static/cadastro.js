console.log("CADASTRO.JS CARREGOU");
alert("dakdoakdoa")

const form = document.querySelector("#registerForm");

form.addEventListener("submit", async (event) => {
  event.preventDefault();

  const username = document.querySelector("#username").value.trim();

  if (!username) return;

  const data = {
    nome: username
  };

  try {
    const response = await fetch("/usuario", {
      method: "POST",


  headers: {
    "Content-Type": "application/json"
  },

  body: JSON.stringify(data)
});

if (!response.ok) {
  throw new Error(`Erro ao cadastrar usuário: ${response.status}`);
}

localStorage.setItem("florence_username", username);
localStorage.removeItem("florence_points");
localStorage.removeItem("florence_time");
localStorage.removeItem("florence_case");

window.location.href = "roleta.html";


  } catch (error) {
      console.error("Erro ao cadastrar:", error);
    }
  });
