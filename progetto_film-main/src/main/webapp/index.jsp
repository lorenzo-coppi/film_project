<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Aggiungi Film</title>
    <style>
        body {
            background-color: #141414;
            font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif;
            color: #ffffff;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
        }

        form {
            background-color: #1f1f1f;
            padding: 40px;
            border-radius: 10px;
            box-shadow: 0 0 15px rgba(0,0,0,0.5);
            width: 100%;
            max-width: 500px;
        }

        h2 {
            text-align: center;
            margin-bottom: 30px;
            color: #e50914;
        }

        label {
            display: block;
            margin-bottom: 15px;
        }

        input {
            width: 100%;
            padding: 10px;
            margin-top: 5px;
            border-radius: 4px;
            border: none;
            background-color: #333;
            color: #fff;
        }

        input:focus {
            outline: none;
            background-color: #444;
        }

        button {
            width: 100%;
            padding: 12px;
            background-color: #e50914;
            border: none;
            border-radius: 5px;
            font-size: 16px;
            color: white;
            cursor: pointer;
            margin-top: 20px;
        }

        button:hover {
            background-color: #f40612;
        }
    </style>
    <script>
        function sendFilm() {
            const film = {
                name: document.getElementById("name").value,
                rating: document.getElementById("rating").value,
                genre: document.getElementById("genre").value,
                released: document.getElementById("released").value,
                score: parseInt(document.getElementById("score").value),
                director: document.getElementById("director").value,
                writer: document.getElementById("writer").value,
                star: document.getElementById("star").value,
                country: document.getElementById("country").value,
                budget: parseFloat(document.getElementById("budget").value),
                gross: parseFloat(document.getElementById("gross").value),
                company: document.getElementById("company").value,
                runtime: parseInt(document.getElementById("runtime").value)
            };

            fetch("/api/conn/nline", {
                method: "POST",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify(film)
            })
            .then(response => {
                if (response.status === 201) {
                    alert("Film creato con successo!");
                } else {
                    alert("Errore durante la creazione del film. Codice: " + response.status);
                }
            })
            .catch(error => {
                console.error("Errore fetch:", error);
            });
        }
    </script>
</head>
<body>
    <form onsubmit="event.preventDefault(); sendFilm();">
        <h2>Inserisci un nuovo film</h2>
        <label>Nome: <input type="text" id="name"/></label>
        <label>Rating: <input type="text" id="rating"/></label>
        <label>Genere: <input type="text" id="genre"/></label>
        <label>Data di uscita: <input type="text" id="released"/></label>
        <label>Score: <input type="number" id="score"/></label>
        <label>Regista: <input type="text" id="director"/></label>
        <label>Sceneggiatore: <input type="text" id="writer"/></label>
        <label>Attore principale: <input type="text" id="star"/></label>
        <label>Paese: <input type="text" id="country"/></label>
        <label>Budget: <input type="number" step="0.01" id="budget"/></label>
        <label>Incassi: <input type="number" step="0.01" id="gross"/></label>
        <label>Casa di produzione: <input type="text" id="company"/></label>
        <label>Durata (min): <input type="number" id="runtime"/></label>
        <button type="submit">Invia</button>
    </form>
</body>
</html>
