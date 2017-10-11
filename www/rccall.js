var exec = require('cordova/exec');

exports.connect = function(success, error) {
    exec(success, error, "RCcall", "connect", []);
};
exports.voiceCall = function(success, error) {
    exec(success, error, "RCcall", "voiceCall", []);
};