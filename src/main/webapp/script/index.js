//frontend
function btn(name) {
    if (name === bookList) {
        document.getElementById('readersList').style.display = 'none';
        document.getElementById('bookList').style.display = 'block';

    } else {
        document.getElementById('readersList').style.display = 'block';
        document.getElementById('bookList').style.display = 'none';

    }
}

//backend
var xhttp = new XMLHttpRequest();

function searchUser() {
    var word = document.getElementById('searchUser');

    if (word != null) {
        xhttp.onreadystatechange = function () {
            if (this.readyState === 4 && this.status === 200) {
                var userList = JSON.parse(this.responseText);
                if (userList.length > 0) {
                    var readerSearchResult = xhttp.responseText;

                }
            }
        }
    }
    xhttp.open(" GET", "/user", true);
    xhttp.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
    xhttp.send(" action=search&reader=" + word);
}

function removeUser(count, userId) {

    if (count > 0) {
        alert(" That user didn't return all book");

    } else {
        xhttp.open("GET", "/removeUser", true);
        xhttp.setRequestHeader(' Content-type', ' application/x-www-form-urlencoded');
        xhttp.send("id=" + userId);

        ///user?action=remove&id=
        /*     let endpoint = "http://localhost:8080/secret_library_war/user";
             $.ajax({
                 url: endpoint,
                 method:"get",
                 data: {
                     "action": "remove",
                     "id": userId
                 },
                 dataType: ' text',

             })*/
    }
}

function checkbox() {
    var str = "";

    var checkbox = document.getElementsByName("co");

    for (var i = 0; i < checkbox.length; i++) {
        if (checkbox[i].checked) {
            str += checkbox[i].value + " ";
        }
    }
    xhttp.open("GET", "/user", true);
    xhttp.setRequestHeader(' Content-type', ' application/x-www-form-urlencoded');
    xhttp.send("action=addToList&books=" + str);

}
