import xml.etree.ElementTree as ET

if __name__ == '__main__':
    tree = ET.parse("bookshelf.xml")
    root = tree.getroot()
    print('root=', root)
    for x in root:
        print(x)
    b = root.get("index")
    print('index=', b)

    print('=== root get children')
    for x in list(root):
        print(x)

    print('===iter')
    for x in root.iter("author"):
        print(x.text)

    print('===findall from root')
    for x in root.findall("author"):
        print(x.text)

    print('===findall from exact parent')
    for x in list(root)[2].findall("author"):
        print(x.text)

    print('===not existing')
    for x in root.iter("not existing"):
        print(x.text)


