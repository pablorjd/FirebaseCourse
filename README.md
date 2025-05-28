Se generan las build variant

se verifica firma del proyecto de debug con este comando ./gradlew signinReport

se firma proyecto con este comando despues de haber generado las keys para firmar proyecto de produccion
keytool -list -v -keystore /Users/pablojimenezdinamarca/cursofirebasepath -alias PabloDevs 