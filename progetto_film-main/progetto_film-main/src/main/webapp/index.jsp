<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Aggiungi Film</title>
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
<h2>Inserisci un nuovo film</h2>
<form onsubmit="event.preventDefault(); sendFilm();">
    <label>Nome: <input type="text" id="name"/></label><br/>
    <label>Rating: <input type="text" id="rating"/></label><br/>
    <label>Genere: <input type="text" id="genre"/></label><br/>
    <label>Data di uscita: <input type="text" id="released"/></label><br/>
    <label>Score: <input type="number" id="score"/></label><br/>
    <label>Regista: <input type="text" id="director"/></label><br/>
    <label>Sceneggiatore: <input type="text" id="writer"/></label><br/>
    <label>Attore principale: <input type="text" id="star"/></label><br/>
    <label>Paese: <input type="text" id="country"/></label><br/>
    <label>Budget: <input type="number" step="0.01" id="budget"/></label><br/>
    <label>Incassi: <input type="number" step="0.01" id="gross"/></label><br/>
    <label>Casa di produzione: <input type="text" id="company"/></label><br/>
    <label>Durata (min): <input type="number" id="runtime"/></label><br/>
    <button type="submit">Invia</button>
</form>
</body>
</html>
