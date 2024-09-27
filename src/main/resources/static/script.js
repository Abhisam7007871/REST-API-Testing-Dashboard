document.getElementById('apiRequestForm').addEventListener('submit', async function (e) {
    e.preventDefault(); // Prevent form submission

    const url = document.getElementById('url').value;
    const method = document.getElementById('method').value;
    const headers = document.getElementById('headers').value;
    const body = document.getElementById('body').value;

    let headersObj = {};
    if (headers) {
        try {
            headersObj = JSON.parse(headers);
        } catch (error) {
            alert('Invalid headers JSON');
            return;
        }
    }

    try {
        const response = await fetch('http://localhost:8080/api/test', {
            method: method,
            headers: {
                ...headersObj,
                'Content-Type': 'application/json',
                'Authorization': 'Basic ' + btoa('user:password') // Change 'user' and 'password' to your credentials
            },
            body: method !== 'GET' ? JSON.stringify(body) : null,
        });

        const responseData = await response.text();
        document.getElementById('response').innerText = responseData;
    } catch (error) {
        console.error('Error:', error);
        document.getElementById('response').innerText = 'Error: ' + error.message;
    }
});
