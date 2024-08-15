const searchInput = document.getElementById('searchInput');
const searchButton = document.getElementById('searchButton');
const productContainer
    = document.getElementById('product-container');

searchButton.addEventListener('click', () => {
    const productName = searchInput.value;

    fetch('http://localhost:8082/product/findByProductName?productName=' + productName)
        .then(response => response.json())
        .then(data => {
            // Verileri döngüye alarak kartları oluştur
            productContainer.innerHTML = ''; // Önceki sonuçları temizle
            data.forEach(product => {
                const productCard = document.createElement('div');
                productCard.className='card';
                productCard.classList.add('product-card');
                productCard.innerHTML = `
                    <h2>${product.productName}</h2>   

                    <p>Açıklama: ${product.description}</p>
                    <p>Renk: ${product.color}</p>
                    <p>Fiyat: ${product.productPrice} TL</p>
                    <p>Stok: ${product.stock}</p>
                `;
                productContainer.appendChild(productCard);
            });
        })
        .catch(error => {
            console.error('Hata:', error);
            productContainer.innerHTML = '<p>Ürün bulunamadı.</p>';
        });
});