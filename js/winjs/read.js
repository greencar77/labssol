var fso = new ActiveXObject("Scripting.FileSystemObject");
var file = fso.OpenTextFile("data.json", 1); // 1 = read

var jsonText = file.ReadAll();
file.Close();

// Parse JSON (safe method for JScript)
//var data = eval("(" + jsonText + ")");
var data = JSON.parse(jsonText);

WScript.Echo("Name: " + data.name);
WScript.Echo("Age: " + data.age);
WScript.Echo("First skill: " + data.skills[0]);