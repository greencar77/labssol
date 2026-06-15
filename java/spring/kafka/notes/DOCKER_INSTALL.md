# Docker Installation Guide

Since Docker is required to run the Kafka broker for this demo, follow these instructions based on your operating system.

## Windows

1.  **Download Docker Desktop:**
    Go to the [Docker Desktop for Windows](https://www.docker.com/products/docker-desktop/) page and click "Download for Windows".
2.  **Install:**
    Run the installer. Docker Desktop supports two installation modes:
    *   **Per-user installation (Recommended):** Does not require administrator privileges for installation or updates.
    *   **All-users installation:** Requires administrator privileges.
    Ensure that the **WSL 2** option is selected (recommended over Hyper-V).
3.  **Restart:**
    You may need to restart your computer after installation.
4.  **Verify:**
    Open PowerShell or Command Prompt and run:
    ```bash
    docker --version
    docker-compose --version
    ```

5.  **Important Note for Connection Errors:**
    Regardless of the installation mode (Per-user or All-users), you must ensure that the Docker Desktop application is **running** and that you have started the required services for this project using:
    ```bash
    docker-compose up -d
    ```
    If you see "Connection to node -1 (localhost/127.0.0.1:9092) could not be established", it usually means the containers are not started or Docker is not running.

## macOS

1.  **Download Docker Desktop:**
    Go to the [Docker Desktop for Mac](https://www.docker.com/products/docker-desktop/) page. Choose the version for your chip (Intel or Apple Silicon).
2.  **Install:**
    Open the `.dmg` file and drag Docker to your Applications folder.
3.  **Run:**
    Open Docker from your Applications folder and follow the setup instructions.
4.  **Verify:**
    Open Terminal and run:
    ```bash
    docker --version
    docker-compose --version
    ```

## Linux (Ubuntu Example)

1.  **Update packages:**
    ```bash
    sudo apt-get update
    ```
2.  **Install Docker:**
    ```bash
    sudo apt-get install docker.io
    ```
3.  **Install Docker Compose:**
    ```bash
    sudo apt-get install docker-compose
    ```
4.  **Manage Docker as a non-root user (optional but recommended):**
    ```bash
    sudo usermod -aG docker $USER
    ```
    *(Log out and log back in for this to take effect)*
5.  **Verify:**
    ```bash
    docker --version
    docker-compose --version
    ```

## Alternative: Docker Engine (Server)
If you are on a server or don't want the GUI, you can install the Docker Engine directly by following the [official documentation](https://docs.docker.com/engine/install/).
