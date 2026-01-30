var fso = new ActiveXObject("Scripting.FileSystemObject");

var filePath = "test.txt";

// Create or overwrite file (true = overwrite)
var file = fso.CreateTextFile(filePath, true);

file.WriteLine("Hello from Windows Script Host!");
file.WriteLine("This was written using pure JavaScript (JScript).");

file.Close();

WScript.Echo("File created successfully!");