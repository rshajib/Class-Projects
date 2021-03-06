<?php

//Login users
require_once("db.php");
$email = $_POST['email'] ;
$password = $_POST['password']  ;

if(isset($_POST['login']) )
 {
    $errors = array() ;

    if( empty($email))
    {
        array_push($errors , "Email is required" ) ;
    }
    if( empty($password))
    {
        array_push($errors , "Password is required" ) ;
    }
    if( count($errors) == 0 )
    {
        $password = md5($password) ;
        $query = "Select * from users where login = '{$email}' AND pwd = '{$password}' " ;
        $results = mysqli_query($db , $query) ;
        $row = $results->fetch_assoc();

        if( mysqli_num_rows($results) ) 
        {
            session_start();
            $_SESSION['email'] = $email ;
            $_SESSION['user_id'] = $row['user_id'];
            $_SESSION['success'] = "Logged in Successfully" ;

            header("Location: dashboard.php");
        }
        else
        {
            array_push($errors , "Wrong email/Password combination. Please try again." ) ;
        }
    }
mysqli_close($db);
 }

 else

 {
session_start() ;


$errors = array() ;

//register users

$name = $_POST['name'] ;
$confirmpassword = $_POST['confirmpassword'] ;

//form validation

if( empty($name) )
{
    array_push( $errors , "Name is required") ;
} 

if( empty($email) )
{
    array_push($errors , "email is required") ;
} 

if( empty($password))
{
    array_push($errors , "Password is required") ;
} 

if( $password != $confirmpassword )
{
    array_push($errors , "Password do not match" ) ;
}

//check database for existing user with same username
$user_check_query = "Select * from users where login = '{$email}' LIMIT 1" ;

$results = mysqli_query( $db , $user_check_query ) ;
$user = mysqli_fetch_assoc($results) ;


if($user)
{
    if($user["login"] === $email)
    {
        array_push($errors , "This email is already registered" ) ;
    }
}

//Register user if no errors

if( count($errors) == 0 )
{
    $password = md5($password) ; //This will encrypt password

    $query = "Insert into users (user_name , login , pwd ) values ( '{$name}' , '{$email}' , '{$password}' )" ;
    mysqli_query($db , $query ) ;

    $_SESSION['user_name'] = $name ;
    $_SESSION['success'] = "You are now signed Up" ;

    header( 'location: index.php' ) ;
    mysqli_close($db);
}
 
}

?>
<?php if (count($errors) > 0) : ?>
    <div>
    <?php foreach($errors as $error) : ?>
    <p><?php echo $error ?></p>
    <?php endforeach ?>
    <!--redirect to index.php after 2 seconds-->
    <?php header("Refresh:2; url= index.php"); ?>
    </div>
    
    <?php endif ?>
    