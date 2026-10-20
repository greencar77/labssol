$ErrorActionPreference = "Stop"
Set-Location $PSScriptRoot

$venvPython = Join-Path $PSScriptRoot ".venv\Scripts\python.exe"
if (-not (Test-Path $venvPython)) {
    py -3 -m venv .venv
    if ($LASTEXITCODE -ne 0) {
        throw "Could not create the virtual environment. Make sure Python 3 is installed."
    }
}

& $venvPython -m pip install --upgrade pip
if ($LASTEXITCODE -ne 0) {
    throw "Could not upgrade pip."
}

& $venvPython -m pip install -r requirements.txt
if ($LASTEXITCODE -ne 0) {
    throw "Could not install the chatbot dependencies."
}

$envFile = Join-Path $PSScriptRoot ".env"
if (-not (Test-Path $envFile)) {
    Copy-Item (Join-Path $PSScriptRoot ".env.example") $envFile
    Write-Host "Created .env from .env.example."
}

Write-Host "Ensure OPENAI_API_KEY is set in .env or your environment."
Write-Host "Setup complete. Start the chatbot with: .\.venv\Scripts\python.exe .\main.py"
