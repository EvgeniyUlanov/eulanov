var $url = window.location.pathname;

$(document).ready(function () {
    //function for navigate
    var navigation = $('#nav');
    $('.content').hide();
    navigation.find('li:first').addClass('active').show();
    $('.content:first').show();

    navigation.find('li').click(function () {
        $('#nav').find('li').removeClass('active');
        $(this).addClass('active');

        $('.content').hide();
        var activeTab = $(this).find('a').attr('href');
        $(activeTab).fadeIn('slow');
        return false;
    });

    //fill countries
    $.post("countries", function (responseJson) {
        var $select = $(".countryId");
        $select.find("option").remove();
        $.each(responseJson, function (index, value) {
            $("<option>").val(value).text(value).appendTo($select);
        });
    });

    //fill cities
    $.post("cities", function (responseJson) {
        var $select = $(".cityId");
        $select.find("option").remove();
        $.each(responseJson, function (index, value) {
            $("<option>").val(value).text(value).appendTo($select);
        });
    });

    //fill roles
    $.post("roles", function (responseJson) {
        var $select = $(".roleId");
        $select.find("option").remove();
        $.each(responseJson, function (index, value) {
            $("<option>").val(value).text(value).appendTo($select);
        });
    });

    FillTable();
    AddActionToUpdateButton();
    AddActionToAddUserButton();
});

function AddActionToAddUserButton() {
    $('#addUserButton').click(function () {
        var name = $('#name').val();
        var login = $('#login').val();
        var email = $('#email').val();
        var password = $('#password').val();
        var role = $('#roleToAdd').val();
        var country = $('#countryToAdd').val();
        var city = $('#cityToAdd').val();
        var JSONObject = {
            "name": name,
            "login": login,
            "email": email,
            "password": password,
            "role": role,
            "country": country,
            "city": city
        };

        $.ajax({
            type: 'POST',
            url: $url + 'add',
            contentType: 'application/json',
            data: JSON.stringify(JSONObject),
            async: false
        });
        FillTable();
    })
}

function FillTable() {
    var $select = $("#tableUsers");
    $select.find('.removable').remove();
    $.post("users", function (responseJson) {
        $.each(responseJson, function (index, user) {
            var tableRaw = $("<tr>").appendTo($select);
            tableRaw.addClass("removable");
            $("<td>").addClass("name").text(user.name).appendTo(tableRaw);
            $("<td>").addClass("login").text(user.login).appendTo(tableRaw);
            $("<td>").addClass("email").text(user.email).appendTo(tableRaw);
            $("<td>").text(user.date).appendTo(tableRaw);
            $("<td>").addClass("role").text(user.role).appendTo(tableRaw);
            $("<td>").addClass("password").text(user.password).appendTo(tableRaw);
            $("<td>").addClass("country").text(user.country).appendTo(tableRaw);
            $("<td>").addClass("city").text(user.city).appendTo(tableRaw);
            var $tdButtonDelete = $('<td>').appendTo(tableRaw);
            $('<button>').addClass("delete").text("delete").appendTo($tdButtonDelete);
            var $tdButtonUpdate = $('<td>').appendTo(tableRaw);
            $('<button>').addClass("updateUser").text("update").appendTo($tdButtonUpdate);
        });
        AddDeleteHandlerToButtonDelete($select);
        AddUpdateHandlerToButtonUpdate($select);
    });
}

function AddDeleteHandlerToButtonDelete(table) {
    table.find('.delete').click(function () {
        var loginToDelete = $(this).closest("tr").find(".login").text();
        $.ajax({
            type: 'GET',
            url: $url + 'delete',
            data: {'login': loginToDelete},
            async: false,
            success: function () {
                FillTable();
            },
            error: function () {
                alert("error receive data");
            }
        })
    })
}

function AddUpdateHandlerToButtonUpdate(table) {
    table.find('.updateUser').click(function () {
        var $nearestTr = $(this).closest("tr");
        var $update = $('#update');

        var oldName = $nearestTr.find(".name").text();
        var oldLogin = $nearestTr.find(".login").text();
        var oldEmail = $nearestTr.find(".email").text();
        var oldPassword = $nearestTr.find(".password").text();
        var oldRole = $nearestTr.find(".role").text();
        var oldCountry = $nearestTr.find(".country").text();
        var oldCity = $nearestTr.find(".city").text();

        $('#oldLogin').val(oldLogin);
        $('#nameToUpdate').val(oldName);
        $('#loginToUpdate').val(oldLogin);
        $('#emailToUpdate').val(oldEmail);
        $('#passwordToUpdate').val(oldPassword);
        $update.find('.roleId').val(oldRole);
        $update.find('.countryId').val(oldCountry);
        $update.find('.cityId').val(oldCity);

        $('.content').hide();
        $update.show();
    })
}

function AddActionToUpdateButton() {
    $('#updateUserButton').click(function () {
        var oldLogin = $('#oldLogin').val();
        var name = $('#nameToUpdate').val();
        var login = $('#loginToUpdate').val();
        var email = $('#emailToUpdate').val();
        var password = $('#passwordToUpdate').val();
        var role = $('#roleToUpdate').val();
        var country = $('#countryToUpdate').val();
        var city = $('#cityToUpdate').val();

        $.ajax({
            type: 'POST',
            url: $url + 'update',
            data: {
                "oldLogin": oldLogin,
                "name": name,
                "login": login,
                "email": email,
                "password": password,
                "role": role,
                "country": country,
                "city": city
            },
            async: false
        });
        FillTable();
    })
}

