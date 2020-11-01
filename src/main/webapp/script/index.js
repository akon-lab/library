function btn(name) {
    if (name == bookList) {
        document.getElementById('readersList').style.display = 'none';
        document.getElementById('bookList').style.display = 'block';

    } else {
        document.getElementById('readersList').style.display = 'block';
        document.getElementById('bookList').style.display = 'none';

    }
}

function searchUser() {
    var xhttp = new XMLHttpRequest();
    var word = document.getElementById('searchUser');
    if (word != null) {
        xhttp.onreadystatechange = function () {
            if (this.readyState == 4 && this.status == 200) {
                var userList = JSON.parse(this.responseText);
                if (userList.length > 0) {
                    var result = xhttp.responseText;
                }
            }
        }
    }
    xhttp.open("GET", "", true);
    xhttp.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
    xhttp.send("action=search&reader=" + word);
}

function addBook() {
    $.ajax({
        url: "/book",
        type: "POST",
        dataType: "html",
        data: function () {
        },
        success: function () {
        },
        error: function () {
        }

    })
}