function sendApiRequest() {
    const url = document.getElementById("url").value;
    const method = document.getElementById("method").value;
    const headers = JSON.parse(document.getElementById("headers").value || '{}');
    const body = document.getElementById("body").value;

    fetch('http://localhost:8080/api/requests', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({
            url: url,
            method: method,
            headers: headers,
            body: body
        })
    })
    .then(response => response.json())
    .then(data => {
        document.getElementById("response").innerText = JSON.stringify(data, null, 2);
    })
    .catch(error => console.error('Error:', error));
}
