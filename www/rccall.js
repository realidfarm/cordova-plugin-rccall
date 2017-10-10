var exec = require('cordova/exec');

exports.voiceCall = function(success, error) {
    exec(success, error, "RCcall", "voiceCall", []);
};