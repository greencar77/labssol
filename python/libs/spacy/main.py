import spacy
from spacy.lang.en.stop_words import STOP_WORDS
import re

nlp = spacy.load("en_core_web_sm")

def extract_vocabulary(text):
    doc = nlp(text)

    vocab = set()

    for token in doc:
        print(token, token.is_stop)
        if (
            token.is_alpha
            and not token.is_stop
            and len(token.text) > 1
        ):
            lemma = token.lemma_.lower()

            if re.fullmatch(r"[a-z]+", lemma):
                vocab.add(lemma)

    return sorted(vocab)


if __name__ == '__main__':
    print(STOP_WORDS)

    text = "She found her keys, opened the door, turned on the lights, and sat on the couch."
    print(extract_vocabulary(text))

    text = "We put the boxes away after moving."
    print(extract_vocabulary(text))
