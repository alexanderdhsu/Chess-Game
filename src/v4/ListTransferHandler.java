package v4;

import java.awt.datatransfer.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class ListTransferHandler extends TransferHandler
{
    public ListTransferHandler(){
    }
    
    protected Transferable createTransferable(JComponent c) {
        return null;
    }
    
    public int getSourceActions(JComponent c) {
        return TransferHandler.COPY_OR_MOVE;
    }
}
