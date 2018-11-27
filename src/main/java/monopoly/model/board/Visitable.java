package monopoly.model.board;

import monopoly.model.Visitor;

public interface Visitable {
    void accept(Visitor visitor);
}
