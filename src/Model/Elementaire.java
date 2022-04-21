package Model;

import outils.Element;

public abstract class Elementaire {
    private Element element;

    public Elementaire(Element element) {
        this.element = element;
    }

    public Element getElement() {
        return element;
    }

    public boolean correspondent(Elementaire el) {
        return this.element == el.element;
    }
 
}
