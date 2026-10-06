// =====================================================
// VERIFICAÇÃO DO USUÁRIO
// =====================================================

// Pega o nome do usuário salvo anteriormente.
const username = localStorage.getItem('florence_username');

// Se não existir usuário, volta para a página inicial.
if (!username) {

    location.href = 'index.html';

}


// Coloca o nome do usuário na tela.
document.getElementById('userBadge').textContent = username || '';


// =====================================================
// ELEMENTOS DA ROLETA
// =====================================================

const wheel = document.getElementById('wheel');

const btn = document.getElementById('spinBtn');

const result = document.getElementById('result');


// =====================================================
// CASOS
// =====================================================

// Categorias disponíveis na roleta.
const cases = [
    'fraude',
    'genocidio',
    'assalto'
];


// Nome que será mostrado na tela para cada categoria.
const names = {

    fraude: 'FRAUDE',

    genocidio: 'GENOCÍDIO',

    assalto: 'ASSALTO'

};


// Impede que a roleta seja executada mais de uma vez
// enquanto ela ainda exstiver girando.
let spinning = false;


// =====================================================
// BOTÃO DA ROLETA
// =====================================================

btn.addEventListener('click', () => {

    if (spinning) return;


    spinning = true;

    btn.disabled = true;

    result.textContent = 'ANALISANDO DISTRIBUIÇÃO...';


    // Escolhe aleatoriamente uma categoria.
    const selected = cases[
        Math.floor(Math.random() * cases.length)
    ];


    // Salva a categoria escolhida.
    localStorage.setItem(
        'florence_case',
        selected
    );


    // =================================================
    // ANIMAÇÃO DA ROLETA
    // =================================================

    const index = cases.indexOf(selected);

    const sectorCenter = index * 120 + 60;

    const extra = 360 * (
        5 + Math.floor(Math.random() * 3)
    );

    const targetRotation =
        extra + (360 - sectorCenter);


    wheel.style.transform =
        `rotate(${targetRotation}deg)`;


    // Espera a animação terminar.
    setTimeout(async () => {


        result.textContent =
            `CASO DESIGNADO: ${names[selected]}`;


        // Encontra o setor correspondente ao caso escolhido.
        const selectedElement =
            document.querySelector(
                `.wheel-label[data-categoria="${selected}"]`
            );


        // Pega o ID do caso armazenado no HTML
        // através do atributo data-caso-id.
        const casoId =
            selectedElement.dataset.casoId;


        // =================================================
        // SALVA O ID DO CASO
        // =================================================

        // A página do caso usará esse ID para buscar
        // novamente os dados na API.
        localStorage.setItem(
            'florence_case_id',
            casoId
        );


        // =================================================
        // TESTE DA API
        // =================================================

        // Faz uma requisição para verificar o caso
        // antes de abrir a página correspondente.
        const response =
            await fetch(`/casos/${casoId}`);


        const caso =
            await response.json();


        // Mostra os dados recebidos no console.
        console.log(
            'Caso recebido pela roleta:',
            caso
        );


        // =================================================
        // ABRE A PÁGINA DO CASO
        // =================================================

        setTimeout(() => {

            location.href =
                selected + '.html';

        }, 1200);


    }, 4500);

});