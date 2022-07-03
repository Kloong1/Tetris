package main.network;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class PlayerDataSender {

    private final ObjectOutputStream oos;

    public PlayerDataSender(OutputStream socketOutputStream) throws IOException {
        this.oos = new ObjectOutputStream(socketOutputStream);
    }

    public void send(PlayerData playerData) throws IOException {
        int tryCnt = 0;
        int maxTryCnt = 2;
        while (tryCnt < maxTryCnt) {
            try {
                oos.writeObject(playerData);
                break;
            } catch (IOException e) {
                if (++tryCnt == maxTryCnt)
                    throw e;
            }
        }
    }
}
