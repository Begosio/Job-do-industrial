# Investigação Florence

Projeto web estático em HTML, CSS e JavaScript.

## Estrutura

- `index.html` — cadastro
- `roleta.html` — distribuição aleatória dos casos
- `genocidio.html` — caso completo
- `fraude.html` — molde do caso
- `assassinato.html` — molde do caso
- `ranking.html` — ranking
- `css/style.css` — estilos globais
- `cadastro.js` — lógica do cadastro
- `js/roleta.js` — lógica da roleta
- `js/genocidio.js` — cronômetro, validações, cálculos e respostas
- `js/caso-molde.js` — cronômetro dos casos em construção
- `js/ranking.js` — cálculo e exibição do ranking
- `img/genocidio/` — imagens do caso de Genocídio
- `img/fraude/` — imagens futuras de Fraude
- `img/assassinato/` — imagens futuras de Assassinato

## Ranking

Atualmente o ranking usa `localStorage` para simular o banco.

No arquivo `js/ranking.js`, a função `loadRankingFromAPI()` é o ponto destinado à futura integração com backend/API.

## Execução

Abra `index.html` no navegador ou sirva a pasta com um servidor local.
