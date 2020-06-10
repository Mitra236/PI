INSERT INTO banke(sifra_banke, naziv_banke, pib, adresa, email, web, fax, telefon, swift) VALUES ("340", "ERSTE BANK", "101626723", "Bulevar Oslobodjenja 7 21102 Novi Sad", "erstebank@email.rs", "www.erstebank.rs", "+381 (0)21 489 06 65", "0800 201 201", "GIBARS22")
INSERT INTO banke(sifra_banke, naziv_banke, pib, adresa, email, web, fax, telefon, swift) VALUES ("160", "BANCA INTESA", "100001159", "Bulevar Mihajla Pupina 4a 21102 Novi Sad", "bancaintesa@email.rs", "www.bancaintesa.rs", "+381 11 310 88 55 ", "+ 381 11 3108888", "DBDBRSBG")
INSERT INTO banke(sifra_banke, naziv_banke, pib, adresa, email, web, fax, telefon, swift) VALUES ("170", "UNICREDIT BANK SRBIJA", "17324918", "Narodnog Fronta 21 21102 Novi Sad", "unicredit@email.rs", "www.unicreditbank.rs", "+021/ 48 03 105", "(381)11-320-4500", "BACXRSBG")

INSERT INTO klijenti(ime, prezime, JMBG, email, telefon, adresa) VALUES ("Pera", "Peric", "1234567891734", "pera@gmail.com", "+38138856385", "Adresa")
INSERT INTO klijenti(ime, prezime, JMBG, email, telefon, adresa) VALUES ("Zika", "Zikic", "1234567891934", "zika@gmail.com", "+38138855385", "Adresa2")
INSERT INTO klijenti(ime, prezime, JMBG, email, telefon, adresa) VALUES ("Mika", "Mikic", "1234567891034", "mika@gmail.com", "+38138888385", "Adresa3")

INSERT INTO drzave(naziv_drzave) VALUES ("Srbija")
INSERT INTO drzave(naziv_drzave) VALUES ("Germany")
INSERT INTO drzave(naziv_drzave) VALUES ("Italy")

INSERT INTO ukidanja(datum_ukidanja, sredstva_se_prenose_na_racun) VALUES ("2020-02-28", "1247 9348 2626 7374")
INSERT INTO ukidanja(datum_ukidanja, sredstva_se_prenose_na_racun) VALUES ("2020-01-01", "8485 9348 2626 7475")

INSERT INTO valute(zvanicna_sifra, naziv, domicilna, drzava) VALUES ("99495", "RSD", 0, 1)
INSERT INTO valute(zvanicna_sifra, naziv, domicilna, drzava) VALUES ("99895", "EUR", 0, 2)

INSERT INTO naseljena_mesta(sifra, naziv, ptt, drzava) VALUES ("234", "Beograd", "8888", 1)
INSERT INTO naseljena_mesta(sifra, naziv, ptt, drzava) VALUES ("847", "Berlin", "9273", 2)
INSERT INTO naseljena_mesta(sifra, naziv, ptt, drzava) VALUES ("900", "Rome", "6438", 3)

INSERT INTO racuni_pravnih_lica(broj_racuna, datum_otvaranja, vazeci, valuta, banka, ukidanje, klijent) VALUES ("1234 3748 9399 2020", "2018-06-23", 0, 1, 1, 1, 1)
INSERT INTO racuni_pravnih_lica(broj_racuna, datum_otvaranja, vazeci, valuta, banka, ukidanje, klijent) VALUES ("0013 6666 3840 4159", "2019-08-24", 0, 2, 2, 2, 2)

INSERT INTO vrste_placanja(oznaka_vrste, naziv_vrste) VALUES ("38483", "debitna kartica")
INSERT INTO vrste_placanja(oznaka_vrste, naziv_vrste) VALUES ("48859", "kreditna kartica")

INSERT INTO dnevno_stanje_racuna(datum_poslednjeg_prometa, prethodno_stanje, promet_u_korist, promet_na_teret, trenutno_stanje, racun_pravnog_lica) VALUES ("2020-03-14", 13000, 15000, 11000, 17000, 1)
INSERT INTO dnevno_stanje_racuna(datum_poslednjeg_prometa, prethodno_stanje, promet_u_korist, promet_na_teret, trenutno_stanje, racun_pravnog_lica) VALUES ("2020-03-13", 57000, 89000, 18000, 100000, 2)
INSERT INTO dnevno_stanje_racuna(datum_poslednjeg_prometa, prethodno_stanje, promet_u_korist, promet_na_teret, trenutno_stanje, racun_pravnog_lica) VALUES ("2020-03-11", 33000, 35000, 11000, 50000, 2)

INSERT INTO transakcije(duznik, svrha_placanja, poverilac, datum_prijema, datum_valute, racun_duznika, model_zaduzenja, poziv_na_broj_zaduzenja, racun_poverioca, model_odobrenja, poziv_na_broj_odobrenja, hitno, iznos, tip_greske, status, naseljeno_mesto, valuta, dnevno_stanje_racuna, vrsta_placanja) VALUES ("maki", "svrha", "betmen", "2019-07-23", "2019-08-08", "1234 5954 3882 9394", 97, "392439248", "43284329048230", 97, "432948329843", 0, 1300, 0, 0, 1, 1, 1, 1)

INSERT INTO kursne_liste(datum, broj_kursne_liste, datum_primene, banka) VALUES ("2020-03-13", 234, "2020-03-15", 1)
INSERT INTO kursne_liste(datum, broj_kursne_liste, datum_primene, banka) VALUES ("2020-03-10", 999, "2020-03-13", 2)
INSERT INTO kursne_liste(datum, broj_kursne_liste, datum_primene, banka) VALUES ("2020-03-14", 254, "2020-03-15", 3)

INSERT INTO kursuvaluti(kupovni, srednji, prodajni, kursna_lista, valuta) VALUES (123.09, 125.12, 127.14, 1, 1)
INSERT INTO kursuvaluti(kupovni, srednji, prodajni, kursna_lista, valuta) VALUES (133.09, 135.12, 137.14, 2, 1)
INSERT INTO kursuvaluti(kupovni, srednji, prodajni, kursna_lista, valuta) VALUES (111.09, 113.12, 115.14, 3, 2)

INSERT INTO medjubankarski_transferi(ukupan_iznos, tip, transakcija, racun_poverioca, racun_nalogodavca) VALUES (55000, "kliring", 1, 1, 2)
INSERT INTO medjubankarski_transferi(ukupan_iznos, tip, transakcija, racun_poverioca, racun_nalogodavca) VALUES (89000, "RTGS", 1, 2, 1)


--	<dependency>
--			<groupId>org.springframework.security</groupId>
--			<artifactId>spring-security-test</artifactId>
--			<scope>test</scope>
--		</dependency>

--<dependency>
--			<groupId>org.springframework.boot</groupId>
--			<artifactId>spring-boot-starter-security</artifactId>
--		</dependency>