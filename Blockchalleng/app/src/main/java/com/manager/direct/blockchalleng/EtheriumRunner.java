
package com.manager.direct.blockchalleng;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import android.widget.Toast;

import com.manager.direct.blockchalleng.Contract.MapChain;

import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.Web3jFactory;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.Contract;
import org.web3j.tx.ManagedTransaction;
import org.web3j.utils.Convert;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class EtheriumRunner extends AsyncTask<String, Void, Void> {
    private String TAG = "ETHERIUM";
    private Handler h;
    private ProgressDialog pd;
    private String contractAddress = "0xae8af0c25c45c2ff5d077b86c8f6cb39fffbabda";
    public static String jsonClient =
            "{\"address\":\"09a5dacb427cc8fd596e5b1640fa539dac1a5d6d\",\"id\":\"0f633608-267f-4e94-b4ef-4f4ba635ef89\",\"version\":3,\"crypto\":{\"cipher\":\"aes-128-ctr\",\"ciphertext\":\"4fc75a27ac790c3308f11c02a356e46cfab8796c866812a5dea9c368c19f6b56\",\"cipherparams\":{\"iv\":\"137a3d2c8c934f1afd108bea643a9ce7\"},\"kdf\":\"scrypt\",\"kdfparams\":{\"dklen\":32,\"n\":262144,\"p\":1,\"r\":8,\"salt\":\"e07cbff898dfc8db886058435d6409d32c11c247b3a9d7544ccb85894ed370e0\"},\"mac\":\"94c0986542d05b14aa481a46752d59c77ebf8443103678c44e2aa8899c326ccb\"}}";






        @Override
        protected void onPreExecute() {

            super.onPreExecute();

        }

        @Override
        protected Void doInBackground(String... params) {
            try {
                TimeUnit.SECONDS.sleep(2);
                Web3j web3j = Web3jFactory.build(new HttpService("https://rinkeby.infura.io/1p6X1Vby9WW11tNcTTg0"));
//        Log.d(TAG, "Connected to Ethereum client version: "
//                + web3j.web3ClientVersion().send().getWeb3ClientVersion());



                Credentials credentials =
                        Credentials.create("9c215ede75b688ce2f30372140068c815b78b2eedfe8bd9af04d8d7fddd8ef2e");

                Log.d("ETHR", " after cred");

                BigInteger _price = BigInteger.ONE;
                _price = MapChain.GAS_PRICE;

                BigInteger _steps = BigInteger.ONE;
                _steps = MapChain.GAS_LIMIT;
                MapChain contract = MapChain.load(contractAddress, web3j,credentials, _price, _steps);
                contract.stopGame().send();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
//        Log.d("ETHR", contractAdmin.getContractAddress());
            Log.d("ETHR", "ok post Exec");
        }


}

