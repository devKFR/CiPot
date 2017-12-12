$(function () {
  var config = {
    apiKey: "AIzaSyAZvjQKMZWEAP0kCAgKndgLh263DmlqidE",
    authDomain: "c-pot-cd7a8.firebaseapp.com",
    databaseURL: "https://c-pot-cd7a8.firebaseio.com",
    projectId: "c-pot-cd7a8",
    storageBucket: "c-pot-cd7a8.appspot.com",
    messagingSenderId: "358614735905"
  };
  firebase.initializeApp(config);

  var state = {
    email: "",
    password: "",
    field: 0,
    subfield: 0,
    kompfield: 0
  };

  $('.js-form').focus(function (e) {
    $("#js-login").text("Login").removeClass().addClass("btn btn-primary");
  });

  $("#js-login").on("click", function (event) {
    event.preventDefault();

    var email = $("#js-email").val() || state.email;
    var password = $("#js-password").val() || state.password;

    setTimeout(function () {
      $("#js-login").html("<i class=\"fa fa-circle-o-notch fa-spin\"></i> Loading").removeClass("btn-primary").addClass("btn-secondary");
      firebase.auth().signInWithEmailAndPassword(email, password).then(function (user) {
        state.email = email;
        state.password = password;
        $("#js-login-data").addClass("hidden");
        $("#js-message-data").removeClass("hidden");
        $("#js-anjay").removeClass("hidden");
        bikin(".utama", "hidden kopian", "#js-submit");
        //console.log(email, password);
      }).catch(function (error) {
        var errorCode = error.code;
        var errorMessage = error.message;

        if (errorCode === 'auth/wrong-password') {
          $("#js-login").html("<i class=\"fa fa-exclamation\"></i> Wrong Password").removeClass("btn-secondary").addClass("btn-danger");
          console.log(errorCode);
        } else {
          alert(errorMessage);
        }
        console.log(error);

        console.log(error);
      });
    }, 1000);
  });

  $("#js-submit").on("click", function (event) {
    event.preventDefault();
    //const message = $('#js-message2').val();

    firebase.auth().signInWithEmailAndPassword(state.email, state.password).then(function (user) {

      pushfire(":", "Indikator");
      pushfire(2, "Subindikator");
      pushfire(3, "Kompetensi");

      $("form").trigger("reset");
      $("#js-submit").addClass("btn-success").html('<span class="fa fa-check"></span> Submitted');
    }).catch(function (error) {
      console.log(error);
    });
  });

  // Ini buat nambah buttonnya
  $(document).on("click", ".btn-add", function (e) {
    e.preventDefault();
    state.field++;
    console.log(state.field);
    var group = $($(".kopian").clone()).insertAfter(".id:last");
    group.addClass("id");
    group.find("input").val("");
    group.removeClass("hidden kopian");

    $(this).removeClass("btn-add").addClass("btn-remove").removeClass("btn-success").addClass("btn-danger").html('<span class="fa fa-minus"></span>');
  }).on("click", ".btn-remove", function (e) {
    $(this).parents(".id").remove();

    state.field--;
    console.log(state.field);
    e.preventDefault();
    return false;
  });
  //=================== BUAT NAMBAHIN SUBINDIKATOR
  $(document).on("click", ".label1", function (e) {
    e.preventDefault();
    var formnya = $(this).prev();
    if ($(formnya).hasClass("hidden")) {
      $(formnya).removeClass("hidden");
      $(this).addClass("hidden");
    }
  });
  //=== atas buat ngilangin teks, bawah buat append
  $(document).on("click", ".btn-add2", function (e) {
    e.preventDefault();
    state.subfield++;
    console.log(state.subfield);
    var controlForm = $(this).parents("form").find(".kompentry:last"),
        currentEntry = $(this).parents(".subentry:first"),
        newEntry = $(currentEntry.clone()).insertBefore(controlForm);

    newEntry.find("input").val("");
    $(this).removeClass("btn-add2").addClass("btn-remove2").removeClass("btn-success").addClass("btn-danger").html('<span class="fa fa-minus"></span>');
  }).on("click", ".btn-remove2", function (e) {
    $(".entry2:hover").remove();

    state.subfield--;
    console.log(state.subfield);
    e.preventDefault();
    return false;
  });
  //=================== BUAT NAMBAHIN KOMPETENSI
  $(document).on("click", ".label2", function (e) {
    e.preventDefault();
    var formnya = $(this).prev();
    if ($(formnya).hasClass("hidden")) {
      $(formnya).removeClass("hidden");
      $(this).addClass("hidden");
    }
  });
  //=== atas buat ngilangin teks, bawah buat append
  $(document).on("click", ".btn-add3", function (e) {
    e.preventDefault();
    state.subfield++;
    console.log(state.subfield);
    var controlForm = $(this).parents(".kompentry"),
        currentEntry = $(this).parents(".kompentry:first"),
        newEntry = $(currentEntry.clone()).insertAfter(controlForm);

    newEntry.find("input").val("");
    $(this).removeClass("btn-add3").addClass("btn-remove3").removeClass("btn-success").addClass("btn-danger").html('<span class="fa fa-minus"></span>');
  }).on("click", ".btn-remove3", function (e) {
    $(".entry3:hover").remove();

    state.kompfield--;
    console.log(state.kompfield);
    e.preventDefault();
    return false;
  });
  //===================== SET DEFAULT BUTTON   ====

  $("#js-message2, #js-message3, #js-message4").focus(function (e) {
    $("#js-submit").removeClass("btn-success").text("Submit");
  });
  //====================== FUNCTION KHUSUS NGE-PUSH ===
  var pushfire = function pushfire(number, status) {
    //di get dulu yang ada di fields[] semuanya trs disimpan di array

    var forFields = "input[name^=\"fields" + number + "\"]";
    var id = 0;
    console.log(forFields);

    var fields = [];

    $(forFields).each(function () {
      fields.push($(this).val());
    });
    console.log(fields);
    //kalo udah, tinggal di foreach arraynya trs push ke firebase
    $.each(fields, function (index, nama) {
      if (nama == "") {
        console.log("error null");
      } else {
        id++;
        firebase.database().ref(status).push({
          nama: nama, id: id
        });
      }
    });
  };
  //======================= BIKIN BARU SUBIN SAMA KOMP
  var bikin = function bikin(ini, kelas, dimana) {
    var kompentry = $($(ini).clone()).insertAfter(dimana);
    kompentry.addClass(kelas);
    kompentry.removeClass("id");
  };
});