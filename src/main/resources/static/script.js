document.getElementById("apiRequestForm").addEventListener("submit", async function(event) {
    event.preventDefault();

    const url = document.getElementById("url").value;
    const method = document.getElementById("method").value;
    const headers = document.getElementById("headers").value;
    const body = document.getElementById("body").value;

    const responseElement = document.getElementById("response");

    try {
        const response = await fetch("http://localhost:8080/api/test/any", {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
                "Authorization": "Basic " + btoa("user:password") // Change to your actual username and password
            },
            body: JSON.stringify({
                url: url,
                method: method,
                headers: headers,
                body: body
            })
        });

        const responseData = await response.text(); // Get response text
        responseElement.innerText = responseData; // Display response
    } catch (error) {
        console.error("Error:", error);
        responseElement.innerText = "Error: " + error.message;
    }
});
