package com.medopad.game.Snapshot.moveVertical;

import com.medopad.game.PointConstant;
import com.medopad.game.Snapshot.Direction;
import com.medopad.game.Snapshot.Snapshot;

public class MoveVerPieceRight extends MoveVerPiece {

    public MoveVerPieceRight(Snapshot from, Direction direction, String val) {
        super(from, direction, val);
    }

    void setSpaceButtons() {
        this.space1.x += VER_LENGTH;
        this.space2.x += VER_LENGTH;
    }

    public void movePiece(PointConstant.Point point, String val) {
        this.maps.set(point.right(), PointConstant.Point.SPACE);
        this.maps.set(point, val);

        if (PointConstant.Point.belongsToVerticalPieceTop(val)) {
            this.maps.set(point.down(), PointConstant.Point.getBottomPieceFromTop(val));
            this.maps.set(point.offset(+1, +1), PointConstant.Point.SPACE);
        } else if (PointConstant.Point.belongsToVerticalPieceBottom(val)) {
            this.maps.set(point.up(), PointConstant.Point.getTopPieceFromBottom(val));
            this.maps.set(point.offset(+1, -1), PointConstant.Point.SPACE);
        }
    }
}
