document.getElementById('registerForm').addEventListener('submit', async function (e) {
    e.preventDefault();
    const data = {
        name: document.getElementById('firstName').value,
        email: document.getElementById('emailId').value,
        password: document.getElementById('password').value,
        phone: document.getElementById('mobileNumber').value,
        address: document.getElementById('address').value,
    };

    const response = await fetch('http://localhost:8080/api/owners/register', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(data),
    });

    const result = await response.json();
    if (result.success) {
        alert(result.message);
    } else {
        alert("Error: " + result.message);
    }
});

document.getElementById('loginForm').addEventListener('submit', async function (e) {
    e.preventDefault();
    const data = {
        email: document.getElementById('loginEmail').value,
        password: document.getElementById('loginPassword').value,
    };

    const response = await fetch('http://localhost:8080/api/owners/login', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(data),
    });

    const result = await response.json();
    if (result.success) {
        alert(result.message);
    } else {
        alert("Error: " + result.message);
    }
});
