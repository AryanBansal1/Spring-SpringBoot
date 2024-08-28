<%@page language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Contact Form</title>
    <link rel="stylesheet" href="style.css">
    
</head>
<body>
    <div class="contact-container">
        <form action="/submit" method="POST"class="contact-left">
            <div class="contact-left-title">
                <h2>Contact Us</h2>
                <hr>
            </div>
            <input type="hidden" name="access_key" value="9791614b-479d-48ae-bab5-3a9820f5b76c">
            <input type="text" id="fname" name="fname" placeholder="Your Full Name" class="contact-inputs" required>
            <input type="email" id="mail" name="mail" placeholder="Your Email" class="contact-inputs" required>
            <textarea name="ltext" id="ltext" placeholder="Type Your Message" class="contact-inputs" required></textarea>
            <input type="submit" value="submit">
        </form>
        <div class="contact-right">
            <img src="assets/backgroundimage.png" alt="" width="500px">
        </div>    
    </div>
    
</body>
</html>