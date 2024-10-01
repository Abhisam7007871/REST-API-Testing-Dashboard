const express = require('express');
const mysql = require('mysql');
const bodyParser = require('body-parser');
const cors = require('cors');

const app = express();
const PORT = 8080; // Change to your desired port

// Middleware
app.use(cors());
app.use(bodyParser.json());

// MySQL Connection
const db = mysql.createConnection({
    host: 'localhost',     // Your MySQL host
    user: 'your_username', // Your MySQL username
    password: 'your_password', // Your MySQL password
    database: 'api_requests' // Your database name
});

db.connect(err => {
    if (err) throw err;
    console.log('MySQL Connected...');
});

// API endpoint to log requests
app.post('/api/log-request', (req, res) => {
    const { url, method, username, headers, body, response } = req.body;

    const query = 'INSERT INTO requests (url, method, username, headers, body, response) VALUES (?, ?, ?, ?, ?, ?)';
    db.query(query, [url, method, username, JSON.stringify(headers), body, response], (err, result) => {
        if (err) return res.status(500).json({ error: err.message });
        res.status(200).json({ message: 'Request logged successfully!' });
    });
});

// Start server
app.listen(PORT, () => {
    console.log(`Server running on http://localhost:${PORT}`);
});
