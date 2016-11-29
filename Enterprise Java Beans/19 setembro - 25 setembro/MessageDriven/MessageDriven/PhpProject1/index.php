<?php

$owner_email = $_POST["owner_email"];
$subject = 'A message from your site visitor ' . $_POST["name"];
$messageBody = "";

$headers = 'MIME-Version: 1.0' . "\r\n";
$headers .= 'Content-type: text/html; charset=iso-8859-1' . "\r\n";
$headers .= 'From:' . $_POST["email"];

if ($_POST['name'] != 'nope') {
    $messageBody .= '<p>Visitor: ' . $_POST["name"] . '</p>' . "\n";
    $messageBody .= '<br>' . "\n";
}
if ($_POST['email'] != 'nope') {
    $messageBody .= '<p>Email Address: ' . $_POST['email'] . '</p>' . "\n";
    $messageBody .= '<br>' . "\n";
} else {
    $headers = '';
}
// if($_POST['state']!='nope'){
// 	$messageBody .= '<p>State: ' . $_POST['state'] . '</p>' . "\n";
// 	$messageBody .= '<br>' . "\n";
// }
if ($_POST['phone'] != 'nope') {
    $messageBody .= '<p>Phone Number: ' . $_POST['phone'] . '</p>' . "\n";
    $messageBody .= '<br>' . "\n";
}
// if($_POST['fax']!='nope'){
// 	$messageBody .= '<p>Fax Number: ' . $_POST['fax'] . '</p>' . "\n";
// 	$messageBody .= '<br>' . "\n";
// }
if ($_POST['message'] != 'nope') {
    $messageBody .= '<p>Message: ' . $_POST['message'] . '</p>' . "\n";
}

if ($_POST["stripHTML"] == 'true') {
    $messageBody = strip_tags($messageBody);
}

// ============= email para o usuário
$resp_assunto = "Contato - Viu na Mesa? - Propaganda em Saco de Pão";
$mensagemCliente = "
	Olá <b>{$_POST["name"]}</b>,
	<br><br>
	Obrigado pelo seu contato.<br>
	Recebemos sua solicitação e brevemente entraremos em contato.
	<br><br><br>

	==============================================<br>
	        Atenciosamente,<br>
	        Equipe Viu na Mesa?<br>
	==============================================<br>
	";

// Função HTML
$headers2 .= "MIME-Version: 1.0\r\n";
$headers2 .= "Content-type: text/html; charset=iso-8859-1\r\n";
$headers2 .= "From: Contao - Viu na Mesa? <contato@viunamesa.com.br>\r\n";


try {
    if (!mail($owner_email, $subject, $messageBody, $headers)) {
        throw new Exception('Problemas com o envio do e-mail.');
    } else {
        if (!mail($_POST['email'], $resp_assunto, $mensagemCliente, $headers2)) {
            throw new Exception('Problemas com o envio do e-mail do cliente.');
        } else {
            echo "E-mail cliente enviado."
        }
        echo 'E-mail enviado.';
    }
} catch (Exception $e) {
    echo $e->getMessage() . "\n";
}
?>
