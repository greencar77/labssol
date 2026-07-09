function validateForm() {
    var title = document.getElementById("title").value;
    if (title.trim() === "") {
        alert("Title cannot be empty");
        return false;
    }
    console.log("Form validated successfully for title: " + title);
    return true;
}

document.addEventListener("DOMContentLoaded", function() {
    console.log("JSP Demo Application Loaded");
});
