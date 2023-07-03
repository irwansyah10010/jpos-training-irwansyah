package com.lawencon.training;

import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;
import org.jpos.iso.ISORequestListener;
import org.jpos.iso.ISOSource;

import java.io.IOException;

public class LogonListener implements ISORequestListener {

    @Override
    public boolean process(ISOSource source, ISOMsg m) {
        try{
            ISOMsg res = (ISOMsg) m.clone();

            if("0810".equals(m.getMTI())){
                res.setMTI("0810");
            }else{
                res.setMTI("0820");
            }

            res.set(39, "00");

            source.send(res);
        }
        catch(ISOException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }

        return false;
    }
}
