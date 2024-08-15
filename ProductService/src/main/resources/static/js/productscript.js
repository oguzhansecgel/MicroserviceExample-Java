let currentPage = 0; // Varsayılan olarak ilk sayfa
const pageSize = 10; // Sayfa başına gösterilecek ürün sayısı

// Function to fetch products with pagination
async function fetchProducts(page = 0) {
    const url = `http://localhost:8083/product/products?page=${page}&size=${pageSize}`;

    try {
        const response = await fetch(url, {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json',
            },
        });

        if (!response.ok) {
            throw new Error(`HTTP error! status: ${response.status}`);
        }

        const data = await response.json();
        displayProducts(data.content); // `content` gelen ürünleri içerir
        updatePaginationControls(data); // Sayfalama kontrollerini güncelle
    } catch (error) {
        console.error('Error fetching products:', error);
        alert('Failed to fetch products. Please check the console for details.');
    }
}

// Function to display products in the UI
function displayProducts(products) {
    const container = document.getElementById('product-container');
    container.innerHTML = ''; // Clear previous content

    if (products.length === 0) {
        container.innerHTML = '<p>Ürün bulunamadı.</p>';
        return;
    }

    products.forEach(product => {
        const card = document.createElement('div');
        card.className = 'card';
        card.innerHTML = `
            <h3>${product.productName}</h3>
            <p>${product.description}</p>
            <p>Color: ${product.color}</p>
            <p>Price: ${product.productPrice} TL</p>
            <p>Stock: ${product.stock}</p>
        `;
        container.appendChild(card);
    });
}

// Function to update pagination controls
function updatePaginationControls(data) {
    const paginationContainer = document.getElementById('pagination-controls');
    paginationContainer.innerHTML = ''; // Önceki içerikleri temizle

    // Geri düğmesi
    if (!data.first) {
        const prevButton = document.createElement('button');
        prevButton.textContent = 'Previous';
        prevButton.addEventListener('click', () => {
            currentPage--;
            fetchProducts(currentPage);
        });
        paginationContainer.appendChild(prevButton);
    }

    // İleri düğmesi
    if (!data.last) {
        const nextButton = document.createElement('button');
        nextButton.textContent = 'Next';
        nextButton.addEventListener('click', () => {
            currentPage++;
            fetchProducts(currentPage);
        });
        paginationContainer.appendChild(nextButton);
    }
}

// Fetch all products on page load
fetchProducts(currentPage);

// Pagination controls container
document.body.innerHTML += '<div id="pagination-controls"></div>';
