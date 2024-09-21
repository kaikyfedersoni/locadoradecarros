document.addEventListener('DOMContentLoaded', fetchCars);

function fetchCars() {
    fetch('http://localhost:8080/carros')
        .then(response => response.json())
        .then(cars => {
            const carList = document.getElementById('carList');
            carList.innerHTML = '';

            cars.forEach(car => {
                const carItem = document.createElement('li');
                carItem.textContent = '${car.placa} - ${car.modelo} - ${car.marca} - $${car.cor}';
                
                
                const deleteButton = document.createElement('button');
                deleteButton.textContent = 'Delete';
                deleteButton.onclick = () => deleteCar(car.id);

                carItem.appendChild(deleteButton);
                carList.appendChild(carItem);
            });
        })
        .catch(error => console.error('Error fetching cars:', error));

}

const carForm = document.getElementById('carForm');
carForm.addEventListener('submit', function(event) {
    event.preventDefault();

    const car = {
        model: document.getElementById('placa').value,
        brand: document.getElementById('modelo').value,
        pricePerDay: document.getElementById('marca').value,
        available: document.getElementById('cor').checked
    };

    fetch('http://localhost:8080/carros', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(car)
    })
    .then(response => response.json())
    .then(newCar => {
        console.log('Car added:', newCar);
        fetchCars();  
    })
    .catch(error => console.error('Error adding car:', error));
});



