module Codewars.Arrays where
import System.IO.Unsafe (unsafePerformIO)
import System.Process (readProcess)
import Data.List

positiveSum :: (Integral i, Show i) => [i] -> Int
positiveSum n = read (unsafePerformIO $ readProcess "perl" ["-e", perlScript (convertArray n)] "")

convertArray :: (Show i) => [i] -> String
convertArray n = "[" ++ (intercalate "," (map show n)) ++ "]"

perlScript :: String -> String
perlScript numbers = unlines
  [ "package JavaScript; sub Return { shift(@_); print(@_); } 1;",
    "package JavaScript; sub Return{ shift(@_); print(@_); } 1; package console; sub log{ shift(@_); print(join(', ',@_),'\n'); } 1; package Array; sub new { my $class = shift; my $self = { _arr => [@_] }; bless $self, $class; return $self; } sub constructor { return new(@_); } sub from { my $class = shift(@_); my $arr = Array->new(); my @arrValues = @{shift(@_)}; foreach my $v (@arrValues) { $arr->push($v); } return $arr; } sub type { return 'Array'; } sub set { my ($self) = shift(@_); my $key = shift(@_); my $val = shift(@_); @{$self->{_arr}}[$key] = $val; } sub get { my ($self) = shift(@_); my $key = shift(@_); return @{$self->{_arr}}[$key]; } sub length { my ($self) = shift(@_); return ~~@{$self->{_arr}}; } sub at { return get(@_); } sub concat { my ($self) = shift(@_); my $arr = shift(@_); push(@{$self->{_arr}}, @{$arr->values()}); return $self; } sub copyWithin { my ($self) = shift(@_); my $target = shift(@_); my $start = shift(@_); my $end = shift(@_); if(not $end){ $end = $self->length + 1; } my $index = 0; my $targetIndex = $target; my @arrValues = @{$self->{_arr}}; foreach my $v (@arrValues) { if($index >= $start && $index < $end){ $self->set($targetIndex,$v); $targetIndex++; } $index++; } return $self } sub entries { my ($self) = shift(@_); my @arrValues = @{$self->{_arr}}; my $entries = Array->new(); my $i=0; foreach my $v (@arrValues) { $entries->push(Array->new($i,$v)); $i++; } return $entries; } sub every { my ($self) = shift(@_); my $lambda = shift(@_); my @arrValues = @{$self->{_arr}}; foreach my $v (@arrValues) { if(not(&{$lambda}($v,$i,@arrValues))){ return 0; } } return 1; } sub fill { my ($self) = shift(@_); my $fill = shift(@_); my $start = shift(@_); if(not $start){ $start = 0; } my $end = shift(@_); if(not $end){ $end = $self->length + 1; } my $index = 0; my @arrValues = @{$self->{_arr}}; foreach my $v (@arrValues) { if($index >= $start && $index < $end){ $self->set($index,$fill); } $index++; } return $self } sub filter { my ($self) = shift(@_); my $lambda = shift(@_); my @arrValues = @{$self->{_arr}}; my $filtered = Array->new(); my $i=0; foreach my $v (@arrValues) { if(&{$lambda}($v,$i,@arrValues)){ $filtered->push($v); } $i++; } return $filtered; } sub find { my ($self) = shift(@_); my $lambda = shift(@_); my @arrValues = @{$self->{_arr}}; foreach my $v (@arrValues) { if(&{$lambda}($v,$i,@arrValues)){ return $v; } } } sub findIndex { my ($self) = shift(@_); my $lambda = shift(@_); my @arrValues = @{$self->{_arr}}; my $i = 0; foreach my $v (@arrValues) { if(&{$lambda}($v,$i,@arrValues)){ return $i; } $i++; } } sub findLast { my ($self) = shift(@_); return $self->reverse()->find(@_); } sub findLastIndex { my ($self) = shift(@_); return $self->reverse()->findIndex(@_); } sub flat { my ($self) = shift(@_); my $depth = shift(@_); my $flat = Array->new(); my @arrValues = @{$self->{_arr}}; foreach my $v (@arrValues) { if(ref($v) == 'ARRAY'){ my @arr = @{$v}; foreach my $x (@arr) { $flat->push($x); } next; } if($v->type == 'Array'){ my @arr = @{$v->{_arr}}; foreach my $x (@arr) { $flat->push($x); } next; } $flat->push($v); } if($depth > 1){ return $flat->flat($depth-1); } return $flat; } sub flatMap { return map(@_)->flat(); } sub forEach { my ($self) = shift(@_); my $lambda = shift(@_); my @arrValues = @{$self->{_arr}}; my $i=0; foreach my $v (@arrValues) { &{$lambda}($v,$i,@arrValues); $i++; } } sub includes { my ($self) = shift(@_); my $test = shift(@_); my @arrValues = @{$self->{_arr}}; foreach my $v (@arrValues) { if($v == $test){ return $true; } } return $false; } sub indexOf { my ($self) = shift(@_); my $test = shift(@_); my @arrValues = @{$self->{_arr}}; my $i=0; foreach my $v (@arrValues) { if($v == $test){ return $i } $i++; } return -1; } sub join{ my ($self) = shift(@_); my $joiner = shift(@_); return join($joiner,@{$self->{_arr}}); } sub keys { my ($self) = shift(@_); my @arrValues = @{$self->{_arr}}; my $keys = Array->new(); my $i=0; foreach my $v (@arrValues) { $keys->push($i); $i++; } return $keys->values(); } sub lastIndexOf { my ($self) = shift(@_); my $test = shift(@_); return $self->length-$self->reverse()->indexOf($test); } sub map { my ($self) = shift(@_); my $lambda = shift(@_); my @arrValues = @{$self->{_arr}}; my $mapped = Array->new(); my $i=0; foreach my $v (@arrValues) { $mapped->push(&{$lambda}($v,$i,@arrValues)); $i++; } return $mapped; } sub push { my ($self) = shift(@_); push(@{$self->{_arr}}, @_); } sub pop { my ($self) = shift(@_); return pop(@{$self->{_arr}}); } sub reduce { my ($self) = shift(@_); my $lambda = shift(@_); my @arrValues = @{$self->{_arr}}; my $i=1; my $x=@arrValues[0]; my $first = 1; if(~~@_>0){ $x=shift(@_); $i=0; $first = 0; } foreach my $y (@arrValues) { if($first){$first = 0;next;} $x=(&{$lambda}($x,$y,$i,@arrValues)); $i++; } return $x; } sub reduceRight { my ($self) = shift(@_); return $self->reverse()->reduce(@_); } sub reverse { my ($self) = shift(@_); my @arrValues = @{$self->{_arr}}; my $reversed = Array->new(); foreach my $v (@arrValues) { $reversed->unshift($v); } return $reversed; } sub shift { my ($self) = shift(@_); return shift(@{$self->{_arr}}); } sub unshift { my ($self) = shift(@_); unshift(@{$self->{_arr}}, @_); return $self; } sub uniq { my ($self) = shift(@_); my %set; my @arrValues = @{$self->{_arr}}; foreach my $v (@arrValues){ $set{$v} = 1; } return Array->new(keys(%set)) } sub values { my ($self) = @_; return @{$self->{_arr}}; } 1;",
    "my $numbers = Array->from(" ++ numbers ++ ");",
    "$numbers = $numbers->filter(sub{return $_[0]>0;});",
    "my $sum = $numbers->reduce(sub{return ($_[0] + $_[1]);},0);",
    "JavaScript->Return($sum);",
    "1;"]
