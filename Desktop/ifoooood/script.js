let currentIndex = 0; // Variável que armazena o índice atual do primeiro item visível no carrossel

function moveCarousel(direction) {
    const track = document.querySelector('.carousel-track'); // Seleciona a faixa do carrossel que contém os itens
    const items = document.querySelectorAll('.carousel-item'); // Seleciona todos os itens do carrossel
    const totalItems = items.length; // Obtém o número total de itens no carrossel
    const itemWidth = items[0].offsetWidth; // Obtém a largura do primeiro item do carrossel
    const containerWidth = document.querySelector('.carousel-container').offsetWidth; // Obtém a largura do contêiner do carrossel
    const itemsInView = Math.floor(containerWidth / itemWidth); // Calcula quantos itens estão visíveis no contêiner

    currentIndex += direction; // Atualiza o índice atual baseado na direção de movimento (1 para próxima, -1 para anterior, etc.)

    // Limita o índice atual para garantir que não ultrapasse os limites do carrossel
    if (currentIndex < 0) {
        currentIndex = 0; // Se o índice for menor que 0, define como 0 para garantir que não haja itens além do início
    } else if (currentIndex + itemsInView > totalItems) {
        currentIndex = totalItems - itemsInView; // Se o índice mais o número de itens visíveis ultrapassar o total de itens, ajusta para mostrar os últimos itens
    }

    const offset = -currentIndex * itemWidth; // Calcula o deslocamento necessário para exibir o item atual no carrossel
    track.style.transform = `translateX(${offset}px)`; // Aplica a transformação CSS para mover a faixa do carrossel horizontalmente
}
