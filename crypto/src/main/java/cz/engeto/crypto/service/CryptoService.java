package cz.engeto.crypto.service;

import cz.engeto.crypto.model.CryptoDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class CryptoService {
    private List<CryptoDTO> cryptos = new ArrayList<>();

    public void addCrypto(CryptoDTO cryptoDTO) {
        cryptos.add(cryptoDTO);
    }

    public List<CryptoDTO> getAllCryptos() {
        return cryptos;
    }

    public List<CryptoDTO> sortCryptosByName() {
        cryptos.sort(Comparator.comparing(CryptoDTO::getName));
        return cryptos;
    }

    public List<CryptoDTO> sortCryptosByPrice() {
        cryptos.sort(Comparator.comparing(CryptoDTO::getPrice));
        return cryptos;
    }

    public List<CryptoDTO> sortCryptosByQuantity() {
        cryptos.sort(Comparator.comparing(CryptoDTO::getQuantity));
        return cryptos;
    }

    // https://chatgpt.com/share/67d881f6-2680-8005-99ea-ab2adad009a0
}
