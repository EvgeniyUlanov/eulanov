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
        var $select = $("#countryId");
        $select.find("option").remove();
        $.each(responseJson, function (index, value) {
            $("<option>").val(value).text(value).appendTo($select);
        });
    });

    //fill cities
    $.post("cities", function (responseJson) {
        var $select = $("#cityId");
        $select.find("option").remove();
        $.each(responseJson, function (index, value) {
            $("<option>").val(value).text(value).appendTo($select);
        });
    });

    //fill roles
    $.post("roles", function (responseJson) {
        var $select = $("#roleId");
        $select.find("option").remove();
        $.each(responseJson, function (index, value) {
            $("<option>").val(value).text(value).appendTo($select);
        });
    });

    //fill table
    $.post("users", function (responseJson) {
        var $select = $("#testTable");
        $.each(responseJson, function (index, user) {
            var tableRaw = $("<tr>").appendTo($select);
            $.each(user, function (index, value) {
                $("<td>").text(value).appendTo(tableRaw);
            });
        });
    });
});