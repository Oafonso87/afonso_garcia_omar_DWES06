<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use Illuminate\Support\Facades\Http;



class UsuarioController extends Controller
{
    /**
     * Display a listing of the resource.
     */
    public function index()
    {
        try {
            // Recuperamos la URL base del microservicio
            $microserviceUrl = config('services.microservice.url');
    
            // Realizamos la petición GET al endpoint /usuarios del microservicio
            $response = Http::get($microserviceUrl . '/usuarios');
    
            // Si la respuesta es exitosa, se envía el JSON tal cual
            if ($response->successful()) {
                return response()->json($response->json(), $response->status());
            } else {
                // Si el microservicio responde con un error, devolvemos ese error
                return response()->json([
                    'status' => 'error',
                    'message' => 'Error en el microservicio',
                    'data' => $response->json(),
                ], $response->status());
            }
        } catch (\Exception $e) {
            // Si no se puede conectar o hay otra excepción, devolvemos un error 500
            return response()->json([
                'status' => 'error',
                'message' => 'No se pudo conectar al microservicio: ' . $e->getMessage(),
                'data' => null,
            ], 500);
        }                 
    }

    /**
     * Show the form for creating a new resource.
     */
    public function create()
    {
        //
    }

    /**
     * Store a newly created resource in storage.
     */
    public function store(Request $request)
    {
        try {
            $microserviceUrl = config('services.microservice.url');
            $response = Http::post($microserviceUrl . '/usuarios', $request->all());
            // Si la respuesta es exitosa, se envía el JSON tal cual
            if ($response->successful()) {
                return response()->json($response->json(), $response->status());
            } else {                
                return response()->json($response->json(), $response->status());
            }
        } catch (\Exception $e) {
            // Si no se puede conectar o hay otra excepción, devolvemos un error 500
            return response()->json([
                'status' => 'error',
                'message' => 'No se pudo conectar al microservicio: ' . $e->getMessage(),
                'data' => null,
            ], 500);
        }        
    }

    /**
     * Display the specified resource.
     */
    public function show(string $id)
    {
        try {
            $microserviceUrl = config('services.microservice.url');
            $response = Http::get($microserviceUrl . '/usuarios/' . $id);
            // Si la respuesta es exitosa, se envía el JSON tal cual
            if ($response->successful()) {
                return response()->json($response->json(), $response->status());
            } else {                
                return response()->json($response->json(), $response->status());
            }
        } catch (\Exception $e) {
            // Si no se puede conectar o hay otra excepción, devolvemos un error 500
            return response()->json([
                'status' => 'error',
                'message' => 'No se pudo conectar al microservicio: ' . $e->getMessage(),
                'data' => null,
            ], 500);
        }
    }

    /**
     * Show the form for editing the specified resource.
     */
    public function edit(string $id)
    {
        
    }

    /**
     * Update the specified resource in storage.
     */
    public function update(Request $request)
    {
        try {
            $microserviceUrl = config('services.microservice.url');
            $response = Http::put($microserviceUrl . '/updateusuarios', $request->all());
            // Si la respuesta es exitosa, se envía el JSON tal cual
            if ($response->successful()) {
                return response()->json($response->json(), $response->status());
            } else {                
                return response()->json($response->json(), $response->status());
            }
        } catch (\Exception $e) {
            // Si no se puede conectar o hay otra excepción, devolvemos un error 500
            return response()->json([
                'status' => 'error',
                'message' => 'No se pudo conectar al microservicio: ' . $e->getMessage(),
                'data' => null,
            ], 500);
        }
    }

    /**
     * Remove the specified resource from storage.
     */
    public function destroy(string $id)
    {
        try {
            $microserviceUrl = config('services.microservice.url');
            $response = Http::delete($microserviceUrl . '/usuarios/' . $id);
            // Si la respuesta es exitosa, se envía el JSON tal cual
            if ($response->successful()) {
                return response()->json($response->json(), $response->status());
            } else {                
                return response()->json($response->json(), $response->status());
            }
        } catch (\Exception $e) {
            // Si no se puede conectar o hay otra excepción, devolvemos un error 500
            return response()->json([
                'status' => 'error',
                'message' => 'No se pudo conectar al microservicio: ' . $e->getMessage(),
                'data' => null,
            ], 500);
        }
        
    }
}