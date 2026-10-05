// =====================================================
// ID DO CASO
// =====================================================

// Pega o ID do caso salvo pela roleta.
const casoId = localStorage.getItem('florence_case_id');

console.log('ID do caso:', casoId);


// Verifica se existe um caso selecionado.
if (!casoId) {

    console.error('Nenhum caso foi selecionado');

} else {

    carregarCaso();

}


// =====================================================
// CARREGAR CASO
// =====================================================

async function carregarCaso() {

    try {

        // Faz a requisição para o Spring Boot.
        const response =
            await fetch(`/casos/${casoId}`);


        // Verifica se a API respondeu com erro.
        if (!response.ok) {

            throw new Error(
                `Erro HTTP: ${response.status}`
            );

        }


        // Converte a resposta JSON para um objeto JavaScript.
        const caso =
            await response.json();


        console.log(
            'Caso recebido da API:',
            caso
        );


        // =================================================
        // ELEMENTOS DO HTML
        // =================================================

        // Encontra o título no HTML.
        const casoTitulo =
            document.getElementById('casoTitulo');


        // Encontra a área da história no HTML.
        const casoDescricao =
            document.getElementById('casoDescricao');


        // Encontra a área das alternativas.
        const options =
            document.getElementById('options');


        // =================================================
        // TÍTULO
        // =================================================

        if (casoTitulo) {

            casoTitulo.textContent =
                caso.titulo;

        }


        // =================================================
        // DESCRIÇÃO / HISTÓRIA
        // =================================================

        if (casoDescricao) {

            casoDescricao.textContent =
                caso.descricao;

        }


        // =================================================
        // ALTERNATIVAS
        // =================================================

        if (options && caso.alternativas) {

            // A API envia tudo em uma String:
            //
            // A. ...|B. ...|C. ...|D. ...|E. ...
            //
            // O split('|') separa cada alternativa.
            const alternativas =
                caso.alternativas.split('|');


            // Cria um elemento HTML para cada alternativa.
            alternativas.forEach((alternativa) => {

                const option =
                    document.createElement('div');


                // Adiciona a classe CSS da alternativa.
                option.classList.add('option');


                // Coloca o texto da alternativa.
                option.textContent =
                    alternativa;


                // Coloca a alternativa dentro de #options.
                options.appendChild(option);

            });

        }

    } catch (error) {

        console.error(
            'Erro ao carregar o caso:',
            error
        );

    }

}