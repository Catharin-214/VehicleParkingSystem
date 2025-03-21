document.addEventListener("DOMContentLoaded", function() {
    loadParkingSlots();

    document.getElementById("vehicle-form").addEventListener("submit", function(event) {
        event.preventDefault();
        parkVehicle();
    });
});

// Load parking slots from the backend
function loadParkingSlots() {
    fetch("/api/slots")
        .then(response => response.json())
        .then(data => {
            const tableBody = document.getElementById("slot-table-body");
            tableBody.innerHTML = "";
            data.forEach(slot => {
                const row = `<tr>
                    <td>${slot.slotNumber}</td>
                    <td>${slot.slotType}</td>
                    <td>${slot.status}</td>
                </tr>`;
                tableBody.innerHTML += row;
            });
        })
        .catch(error => console.error("Error fetching slots:", error));
}

// Function to park a vehicle
function parkVehicle() {
    const vehicleData = {
        licensePlate: document.getElementById("licensePlate").value,
        vehicleType: document.getElementById("vehicleType").value,
        ownerName: document.getElementById("ownerName").value,
        contactNumber: document.getElementById("contactNumber").value
    };

    fetch("/api/park", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(vehicleData)
    })
    .then(response => response.json())
    .then(data => {
        alert(data.message);
        loadParkingSlots();
    })
    .catch(error => console.error("Error parking vehicle:", error));
}
