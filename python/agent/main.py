from dotenv import load_dotenv
from openai import APIError, OpenAI


MODEL = "gpt-4o-mini"


def main():
    load_dotenv()
    client = OpenAI()
    messages = [
        {
            "role": "developer",
            "content": "You are a helpful assistant. Keep your answers clear and concise.",
        }
    ]

    print("Chatbot ready. Type /quit or /exit to end the conversation.")
    while True:
        try:
            user_message = input("You: ").strip()
        except (EOFError, KeyboardInterrupt):
            print("\nGoodbye!")
            break

        if user_message.lower() in {"/quit", "/exit"}:
            print("Goodbye!")
            break
        if not user_message:
            continue

        messages.append({"role": "user", "content": user_message})
        try:
            response = client.chat.completions.create(
                model=MODEL,
                messages=messages,
            )
        except APIError as error:
            messages.pop()
            print(f"OpenAI API error: {error}")
            continue

        assistant_message = response.choices[0].message.content
        if assistant_message is None:
            messages.pop()
            print("The assistant returned an empty response.")
            continue

        messages.append({"role": "assistant", "content": assistant_message})
        print(f"Assistant: {assistant_message}")


if __name__ == "__main__":
    main()
