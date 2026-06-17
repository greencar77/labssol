document.addEventListener('DOMContentLoaded', () => {
    const itemList = document.getElementById('item-list');
    const overlay = document.getElementById('overlay');
    const popup = document.getElementById('popup');
    const popupTitle = document.getElementById('popup-title');
    const popupLinks = document.getElementById('popup-links');
    const closeBtn = document.getElementById('close-btn');

    // Sample data for links based on item clicked
    const itemData = {
        '1': [
            { text: 'Google', url: 'https://google.com' },
            { text: 'GitHub', url: 'https://github.com' }
        ],
        '2': [
            { text: 'MDN Web Docs', url: 'https://developer.mozilla.org' },
            { text: 'Stack Overflow', url: 'https://stackoverflow.com' }
        ],
        '3': [
            { text: 'YouTube', url: 'https://youtube.com' },
            { text: 'Reddit', url: 'https://reddit.com' }
        ],
        '4': [
            { text: 'Wikipedia', url: 'https://wikipedia.org' },
            { text: 'Amazon', url: 'https://amazon.com' }
        ]
    };

    function openPopup(itemId, itemName) {
        popupTitle.textContent = itemName;
        popupLinks.innerHTML = '';

        const links = itemData[itemId] || [];
        links.forEach(link => {
            const li = document.createElement('li');
            const a = document.createElement('a');
            a.href = link.url;
            a.textContent = link.text;
            a.target = '_blank';
            li.appendChild(a);
            popupLinks.appendChild(li);
        });

        overlay.style.display = 'flex';
    }

    function closePopup() {
        overlay.style.display = 'none';
    }

    // Event delegation for item clicks
    itemList.addEventListener('click', (e) => {
        const item = e.target.closest('.item');
        if (item) {
            const itemId = item.getAttribute('data-id');
            const itemName = item.textContent;
            openPopup(itemId, itemName);
        }
    });

    // Close on button click
    closeBtn.addEventListener('click', closePopup);

    // Close on click outside the popup
    overlay.addEventListener('click', (e) => {
        if (e.target === overlay) {
            closePopup();
        }
    });

    // Close on Esc key press
    document.addEventListener('keydown', (e) => {
        if (e.key === 'Escape') {
            closePopup();
        }
    });
});
