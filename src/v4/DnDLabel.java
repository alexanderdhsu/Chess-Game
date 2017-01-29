package v4;

import java.awt.Point;
import java.awt.datatransfer.*;
import java.awt.dnd.*;
import java.io.IOException;

import javax.swing.*;

/**
 * Using this as an example to work from.
 * 
 * Our custom JLabel class that is Draggable.
 * This JButton is Transferable (so it can be Dragged),
 * And listens for its own drags
 * */
@SuppressWarnings("serial")
public class DnDLabel extends JLabel implements Transferable,
DragSourceListener, DragGestureListener, DropTargetListener {

    private DragSource source;         //marks this JLabel as the source of the Drag
    private TransferHandler t;
    private DropTarget target;

    public DnDLabel(String message){
        super(message);

        //The TransferHandler returns a new DnDLabel to be transferred in the Drag
        t = new TransferHandler(){
              public Transferable createTransferable(JComponent c){
                    return new DnDLabel(getText());
              }
        };
        setTransferHandler(t);

        //The Drag will copy the DnDLabel rather than moving it
        source = new DragSource();
        source.createDefaultDragGestureRecognizer(this, DnDConstants.ACTION_COPY, this);
        
        target = new DropTarget(this,this);
        setTransferHandler(new MyTransferHandler());
    }

    //The DataFlavor is a marker to let the DropTarget know how to handle the Transferable
    public DataFlavor[] getTransferDataFlavors() {
        return new DataFlavor[]{
                new DataFlavor(DnDLabel.class, "JLabel")
        };
    }
    public boolean isDataFlavorSupported(DataFlavor flavor) {
        return true;
    }
    public Object getTransferData(DataFlavor flavor) {
        return this;
    }
    
    public void dragEnter(DragSourceDragEvent dsde) {}
    public void dragOver(DragSourceDragEvent dsde) {}
    public void dropActionchanged(DragSourceDragEvent dsde) {}
    public void dragExit(DragSourceEvent dse) {}
    public void dragDropEnd(DragSourceDropEvent dsde) {}
    //when a DragGesture is recognised, initiate the Drag
    public void dragGestureRecognized(DragGestureEvent dge) {
         source.startDrag(dge, DragSource.DefaultMoveDrop, new DnDLabel("Text"), this);        
    }

    @Override
    public void dropActionChanged(DragSourceDragEvent dsde) {}
    @Override
    public void dragEnter(DropTargetDragEvent dtde) {}
    @Override
    public void dragOver(DropTargetDragEvent dtde) { }
    @Override
    public void dropActionChanged(DropTargetDragEvent dtde) { }
    @Override
    public void dragExit(DropTargetEvent dte) { }
    @Override
    public void drop(DropTargetDropEvent dtde) {
        try {
            Transferable t = dtde.getTransferable();
            DataFlavor[] d = t.getTransferDataFlavors();
            DnDLabel tempLabel = (DnDLabel)t.getTransferData(d[0]);
            ((MyTransferHandler)getTransferHandler()).importData(this, (DnDLabel)t.getTransferData(d[0]));            
        } catch (UnsupportedFlavorException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally{ dtde.dropComplete(true); }
    }
}

@SuppressWarnings("serial")
class MyTransferHandler extends TransferHandler {
    public boolean importData(JComponent comp, Transferable t, Point p){
        return true;
        
        try {
            DnDLabel tempLabel = (DnDLabel)t.getTransferData(new DataFlavor(DnDLabel.class, "JLabel"));
            DnDLabel[] thing;
            thing[0] = tempLabel;
        } 

    }
}